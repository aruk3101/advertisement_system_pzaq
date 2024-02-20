import "./Card.css";

function Card(props) {
  let customPadding =
    props.customPadding == undefined || props.customPadding == null
      ? "p-1 p-sm-3 p-md-4"
      : props.customPadding;
  return (
    <div className="row" id={props.id}>
      <div className="col mb-4">
        {props.beforeContent ?? ""}
        <div className={"rounded bg-white " + customPadding}>
          <div className="mt-3">
            <h1
              className={
                "text-we fw-bold pb-0 " +
                (props.customMargin + " " ?? " mb-3 ") +
                (props.bootstrapFontsize + " " ?? " fs-3 ") +
                (props.headerCenter + " " ?? " text-left ")
              }
            >
              {props.header}
            </h1>
            <h2 className="fs-6 text-black-50">{props.children}</h2>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Card;
