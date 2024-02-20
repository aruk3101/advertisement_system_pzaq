import { Link } from "react-router-dom";

export default function SvgButton({
  href,
  svg,
  variant = "default",
  border = "black",
}) {
  let classnames = "";
  switch (variant) {
    case "pill":
      classnames += " rounded-pill";
      break;
    default:
      break;
  }
  classnames += " border-" + border;

  return (
    <Link to={href} className="border-icon">
      <div
        className={
          "m-1 border border-4 border-custom-dark d-inline-block p-1" +
          classnames
        }
      >
        {svg}
      </div>
    </Link>
  );
}
