document.addEventListener("DOMContentLoaded", function () {
    const reviewsContainer = document.querySelector(".reviews-container");
    const reviews = document.querySelectorAll(".review");
    const reviewWidth = reviews[0].offsetWidth + 13; // Ширина одного отзыва + gap
    let isScrolling = false;

    // Функция для прокрутки вправо
    function scrollRight() {
        if (isScrolling) return;
        isScrolling = true;

        reviewsContainer.scrollBy({ left: reviewWidth, behavior: "smooth" });

        setTimeout(() => {
            if (reviewsContainer.scrollLeft >= reviewsContainer.scrollWidth - reviewsContainer.clientWidth) {
                reviewsContainer.scrollLeft = 0; // Зацикливаем скролл
            }
            isScrolling = false;
        }, 500); // Время для завершения анимации
    }

    // Обработчик клика для прокрутки вправо
    reviewsContainer.addEventListener("click", scrollRight);
});