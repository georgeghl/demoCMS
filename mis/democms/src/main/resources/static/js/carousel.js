// 轮播图功能
class Carousel {
    constructor(containerSelector) {
        this.container = document.querySelector(containerSelector);
        if (!this.container) return;
        
        this.slides = this.container.querySelectorAll('.slide');
        this.controls = this.container.querySelectorAll('.banner-control');
        this.currentSlide = 0;
        this.interval = null;
        
        this.init();
    }
    
    init() {
        // 初始化显示第一张幻灯片
        this.showSlide(0);
        
        // 设置控制点点击事件
        this.controls.forEach((control, index) => {
            control.addEventListener('click', () => {
                this.showSlide(index);
                this.restartAutoPlay();
            });
        });
        
        // 开始自动播放
        this.startAutoPlay();
        
        // 鼠标悬停时暂停自动播放
        this.container.addEventListener('mouseenter', () => {
            this.stopAutoPlay();
        });
        
        // 鼠标离开时恢复自动播放
        this.container.addEventListener('mouseleave', () => {
            this.startAutoPlay();
        });
    }
    
    showSlide(n) {
        // 隐藏所有幻灯片和控制点
        this.slides.forEach(slide => slide.classList.remove('active'));
        this.controls.forEach(control => control.classList.remove('active'));
        
        // 更新当前幻灯片索引
        this.currentSlide = (n + this.slides.length) % this.slides.length;
        
        // 显示当前幻灯片和控制点
        this.slides[this.currentSlide].classList.add('active');
        this.controls[this.currentSlide].classList.add('active');
    }
    
    nextSlide() {
        this.showSlide(this.currentSlide + 1);
    }
    
    startAutoPlay() {
        this.stopAutoPlay();
        this.interval = setInterval(() => {
            this.nextSlide();
        }, 5000);
    }
    
    stopAutoPlay() {
        if (this.interval) {
            clearInterval(this.interval);
            this.interval = null;
        }
    }
    
    restartAutoPlay() {
        this.stopAutoPlay();
        this.startAutoPlay();
    }
}

// 初始化轮播图
document.addEventListener('DOMContentLoaded', function() {
    new Carousel('.banner');
});