// 页面加载完成后执行
document.addEventListener('DOMContentLoaded', function() {
    // 设置当前页面导航激活状态
    setActiveNavigation();
    
    // 初始化查看更多功能
    // initShowMore();

    initImageModal();
});

// 设置导航激活状态
function setActiveNavigation() {
    const currentPage = window.location.pathname.split('/').pop();
    const navLinks = document.querySelectorAll('.nav-link');
    
    navLinks.forEach(link => {
        const linkHref = link.getAttribute('href');
        if (linkHref === currentPage || (currentPage === '' && linkHref === 'index.html')) {
            link.classList.add('active');
        } else {
            link.classList.remove('active');
        }
    });
}

// 初始化查看更多功能
function initShowMore() {
    const noticeItems = document.querySelectorAll('.notice-item');
    const showMoreBtn = document.querySelector('.more-link');
    
    if (!showMoreBtn || noticeItems.length <= 5) return;
    
    // 默认只显示前5条通知
    for (let i = 5; i < noticeItems.length; i++) {
        noticeItems[i].style.display = 'none';
    }
    
    let showingAll = false;
    
    showMoreBtn.addEventListener('click', function(e) {
        e.preventDefault();
        
        if (showingAll) {
            // 收起，只显示前5条
            for (let i = 5; i < noticeItems.length; i++) {
                noticeItems[i].style.display = 'none';
            }
            showMoreBtn.innerHTML = '查看更多 <i class="fas fa-arrow-down"></i>';
        } else {
            // 展开，显示所有
            for (let i = 5; i < noticeItems.length; i++) {
                noticeItems[i].style.display = 'flex';
            }
            showMoreBtn.innerHTML = '收起 <i class="fas fa-arrow-up"></i>';
        }
        
        showingAll = !showingAll;
    });
}

// 图片放大功能
function initImageModal() {
    const modal = document.getElementById('imageModal');
    const modalImg = document.getElementById('modalImage');
    const captionText = document.getElementById('modalCaption');
    const closeBtn = document.querySelector('.modal-close');
    
    if (!modal) return;
    
    // 为所有图片添加点击事件
    document.querySelectorAll('.gallery-item img').forEach(img => {
        img.addEventListener('click', function() {
            modal.style.display = 'block';
            modalImg.src = this.src;
            captionText.innerHTML = this.alt;
        });
    });
    
    // 关闭按钮
    closeBtn.addEventListener('click', function() {
        modal.style.display = 'none';
    });
    
    // 点击模态框背景关闭
    modal.addEventListener('click', function(e) {
        if (e.target === modal) {
            modal.style.display = 'none';
        }
    });
    
    // ESC键关闭
    document.addEventListener('keydown', function(e) {
        if (e.key === 'Escape' && modal.style.display === 'block') {
            modal.style.display = 'none';
        }
    });
}
