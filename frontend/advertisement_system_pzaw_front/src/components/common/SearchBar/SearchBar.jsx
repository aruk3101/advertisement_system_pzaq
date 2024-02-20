import "./SearchBar.css";

export default function SearchBar({ variant = "default", withBorder = false }) {
  let size;
  if (variant) {
    switch (variant) {
      case "sm":
        size = 13;
        break;
      case "lg":
        size = 20;
        break;
      default:
        size = 16;
        break;
    }
  }

  return (
    <form className="d-flex me-auto ms-auto" role="search">
      <input
        className={
          "form-control rounded-0 " +
          (variant && variant === "default" ? "" : "form-control-" + variant)
        }
        type="search"
        placeholder="Search"
        aria-label="Search"
      />
      <button
        className={"btn bg-white rounded-0 " + (withBorder && "border")}
        type="submit"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width={size}
          height={size}
          fill="currentColor"
          class="bi bi-search"
          viewBox="0 0 16 16"
        >
          <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
        </svg>
      </button>
    </form>
  );
}
