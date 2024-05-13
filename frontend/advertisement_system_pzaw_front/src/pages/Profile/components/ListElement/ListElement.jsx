import { EditPopupTrigger } from "components/EditPopup/EditPopup";
import { DeleteButton } from "components/common/DeleteButton/DeleteButton";

export default function ListElement(props) {
  return (
    <li class="list-group-item">
      <h1 className="fs-5 mb-0">{props.h1}</h1>
      <h2 className="fs-6 mb-0">{props.h2}</h2>
      <span className="smaller-font-1 text-black-50">
        {props.date == null
          ? props.location +
            ", " +
            props.period_start +
            " - " +
            props.period_end
          : "Data uzyskania : " + props.date}
      </span>

      {props.level == null ? (
        ""
      ) : (
        <h3 className="fs-5 mt-2 mb-0 d-flex align-items-center">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            fill="currentColor"
            class="bi bi-book me-2"
            viewBox="0 0 16 16"
          >
            <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783" />
          </svg>
          {props.level}
        </h3>
      )}
      {props.duties == null ? (
        ""
      ) : (
        <div>
          <h4 className="fs-5 mb-0">Obowiązki: </h4>
          <ul className="duties">
            {props.duties.map((value) => {
              console.log(value);
              return (
                <li>
                  {value.duty}{" "}
                  <DeleteButton variant={"Duty"} uuid={value.uuid} />
                </li>
              );
            })}
          </ul>
        </div>
      )}
      <DeleteButton variant={props.variant} uuid={props.element.uuid} />
      <EditPopupTrigger variant={props.variant} element={props.element} />
    </li>
  );
}
