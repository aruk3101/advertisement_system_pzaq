import Card from "components/common/Card/Card";
import { Link } from "react-router-dom";

export default function Links() {
  return (
    <Card
      header="Linki"
      bootstrapFontsize="fs-5"
      headerCenter="text-center"
      id="linki"
    >
      <ul className="list-group list-group-flush">
        <li className="list-group-item">
          <Link className="text-decoration-none text-center" to={"/"}>
            Github
          </Link>
        </li>
        <li className="list-group-item">
          <Link className="text-decoration-none text-center" to={"/"}>
            Linkedin
          </Link>
        </li>
        <li className="list-group-item">
          <Link className="text-decoration-none text-center" to={"/"}>
            Facebook
          </Link>
        </li>
      </ul>
    </Card>
  );
}
