// news-board.js
document.addEventListener('DOMContentLoaded', () => {
    // 配置分页参数
    const ITEMS_PER_PAGE = 15; // 每页15条
    let currentPage = 1; // 当前页码
    let totalPages = 1; // 总页数

    // 通用分页加载函数
    function loadPaginatedData(section, apiPrefix, listId, paginationId) {
        // 获取总记录数
        fetch(`/api/${apiPrefix}/getCount`)
            .then(response => response.json())
            .then(count => {
                totalPages = Math.ceil(count / ITEMS_PER_PAGE); // 计算总页数
                loadPage(section, apiPrefix, listId, paginationId, currentPage);
            })
            .catch(error => console.error(`Error fetching count for ${apiPrefix}:`, error));
    }

    // 加载指定页数据
    function loadPage(section, apiPrefix, listId, paginationId, page) {
        currentPage = page;
        const offset = (page - 1) * ITEMS_PER_PAGE;
        fetch(`/api/${apiPrefix}/getDescOffsetLimit`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ offset, limit: ITEMS_PER_PAGE })
        })
            .then(response => response.json())
            .then(items => {
                // 渲染列表
                const list = document.getElementById(listId);
                list.innerHTML = ''; // 清空现有内容
                items.forEach(item => {
                    const li = document.createElement('li');
                    li.className = 'notice-item';
                    li.innerHTML = `
                        <a class="notice-a" href="/${section}/detail/${item.uid}">${item.title}</a>
                        <span class="notice-date"><i class="far fa-calendar-alt"></i> ${item.time}</span>
                    `;
                    list.appendChild(li);
                });

                // 渲染分页控件
                renderPagination(paginationId, section, apiPrefix, listId);
            })
            .catch(error => console.error(`Error fetching ${apiPrefix} data:`, error));
    }

    // 渲染分页控件
    function renderPagination(paginationId, section, apiPrefix, listId) {
        const pagination = document.getElementById(paginationId);
        pagination.innerHTML = ''; // 清空现有分页

        // 上一页
        const prevLink = document.createElement('a');
        prevLink.className = `page-link ${currentPage === 1 ? 'disabled' : ''}`;
        prevLink.innerHTML = '<i class="fas fa-chevron-left"></i> 上一页';
        if (currentPage > 1) {
            prevLink.addEventListener('click', (e) => {
                e.preventDefault();
                loadPage(section, apiPrefix, listId, paginationId, currentPage - 1);
            });
        }
        pagination.appendChild(prevLink);

        // 页码
        for (let i = 1; i <= totalPages; i++) {
            const pageLink = document.createElement('a');
            pageLink.className = `page-link ${i === currentPage ? 'active' : ''}`;
            pageLink.textContent = i;
            pageLink.addEventListener('click', (e) => {
                e.preventDefault();
                loadPage(section, apiPrefix, listId, paginationId, i);
            });
            pagination.appendChild(pageLink);
        }

        // 下一页
        const nextLink = document.createElement('a');
        nextLink.className = `page-link ${currentPage === totalPages ? 'disabled' : ''}`;
        nextLink.innerHTML = '下一页 <i class="fas fa-chevron-right"></i>';
        if (currentPage < totalPages) {
            nextLink.addEventListener('click', (e) => {
                e.preventDefault();
                loadPage(section, apiPrefix, listId, paginationId, currentPage + 1);
            });
        }
        pagination.appendChild(nextLink);
    }

    // 初始化分页
    // loadPaginatedData('news', 'news', 'news-list', 'news-pagination');
    // loadPaginatedData('affair', 'affair', 'affair-list', 'affair-pagination');
    loadPaginatedData('notice', 'notice', 'notice-list', 'notice-pagination');
});