// affair-service-board.js
document.addEventListener('DOMContentLoaded', () => {
    const ITEMS_PER_PAGE = 6; // 每页6条
    let currentPage = 1; // 当前页码
    let totalPages = 1; // 总页数

    // 加载云服务分页数据
    function loadPaginatedData() {
        fetch('/api/affairService/getCount')
            .then(response => {
                if (!response.ok) throw new Error(`Failed to fetch count: ${response.status}`);
                return response.json();
            })
            .then(count => {
                totalPages = Math.ceil(count / ITEMS_PER_PAGE);
                console.log(`Total affairService items: ${count}, Total pages: ${totalPages}`);
                loadPage(currentPage);
            })
            .catch(error => console.error('Error fetching affairService count:', error));
    }

    // 加载指定页数据
    function loadPage(page) {
        currentPage = page;
        const offset = (page - 1) * ITEMS_PER_PAGE;
        const requestBody = { offset: offset, limit: ITEMS_PER_PAGE };
        console.log(`Fetching affairService data with offset: ${offset}, limit: ${ITEMS_PER_PAGE}`);

        fetch('/api/affairService/getAscOffsetLimit', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
            .then(response => {
                if (!response.ok) throw new Error(`Failed to fetch data: ${response.status}`);
                return response.json();
            })
            .then(items => {
                console.log('Received affairService items:', items);
                const list = document.getElementById('affair-service-list');
                list.innerHTML = items.length === 0 ? '<div class="affair-service-card">暂无数据</div>' : '';
                items.forEach(item => {
                    const card = document.createElement('div');
                    card.className = 'affair-service-card';
                    card.innerHTML = `
                        <a class="notice-a" href="/affair/service/detail/${item.uid}">
                            <div class="affair-service-photo">
                                <img src="${item.cover || '/img/asset/placeholder_people.jpg'}" 
                                     alt="${item.title}" 
                                     onerror="this.src='/img/asset/placeholder_people.jpg'">
                            </div>
                            <div class="affair-service-info">
                                <p><strong>${item.title}</strong></p>
                                <p>${item.desp}</p>
                            </div>
                        </a>
                    `;
                    list.appendChild(card);
                });
                renderPagination();
            })
            .catch(error => {
                console.error('Error fetching affairService data:', error);
                document.getElementById('affair-service-list').innerHTML = '<div class="affair-service-card">加载失败，请稍后重试</div>';
            });
    }

    // 渲染分页控件
    function renderPagination() {
        const pagination = document.getElementById('affair-service-pagination');
        pagination.innerHTML = '';

        const prevLink = document.createElement('a');
        prevLink.className = `page-link ${currentPage === 1 ? 'disabled' : ''}`;
        prevLink.innerHTML = '<i class="fas fa-chevron-left"></i> 上一页';
        if (currentPage > 1) {
            prevLink.addEventListener('click', (e) => {
                e.preventDefault();
                loadPage(currentPage - 1);
            });
        }
        pagination.appendChild(prevLink);

        for (let i = 1; i <= totalPages; i++) {
            const pageLink = document.createElement('a');
            pageLink.className = `page-link ${i === currentPage ? 'active' : ''}`;
            pageLink.textContent = i;
            pageLink.addEventListener('click', (e) => {
                e.preventDefault();
                loadPage(i);
            });
            pagination.appendChild(pageLink);
        }

        const nextLink = document.createElement('a');
        nextLink.className = `page-link ${currentPage === totalPages ? 'disabled' : ''}`;
        nextLink.innerHTML = '下一页 <i class="fas fa-chevron-right"></i>';
        if (currentPage < totalPages) {
            nextLink.addEventListener('click', (e) => {
                e.preventDefault();
                loadPage(currentPage + 1);
            });
        }
        pagination.appendChild(nextLink);
    }

    // 初始化分页
    loadPaginatedData();
});