import "./SimpleCarousel.css";

export default function SimpleCarousel({ id, children }) {
  return (
    <div id={id} class="carousel slide border border-0 rounded-4 bg-secondary">
      <div class="carousel-inner">{children}</div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target={"#" + id}
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target={"#" + id}
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  );
}
