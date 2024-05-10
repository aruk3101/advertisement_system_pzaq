import { useRef, useEffect, useState } from "react";
import EditUserDataForm from "./EditUserDataForm/EditUserDataForm";
import editIcon from "assets/images/edit-icon.svg";

const id = "EditPopupModal";

var currentVariant = "";

export function EditPopup(props) {
  const modalRef = useRef(null);
  const closeRef = useRef(null);
  const [content, setContent] = useState();

  const forceClose = () => {
    closeRef.current.click();
  };

  useEffect(() => {
    const modalElement = modalRef.current;
    const shownHandler = () => {
      switch (currentVariant) {
        case "UserData":
          setContent(<EditUserDataForm forceClose={forceClose} />);
          break;
        default:
          setContent(
            <>
              <p>
                Wystąpił błąd. Skontaktuj się z administratorem lub spróbuj
                ponownie.
              </p>
            </>
          );
          break;
      }

      console.log("Modal został pokazany");
      console.log(currentVariant);
    };
    const hiddenHandler = () => {
      console.log("Modal został ukryty");
      currentVariant = "";
      console.log(currentVariant);
      setContent("");
    };

    // Dodajemy nasłuchiwanie zdarzeń do modalu
    if (modalElement) {
      modalElement.addEventListener("shown.bs.modal", shownHandler);
      modalElement.addEventListener("hidden.bs.modal", hiddenHandler);
    }

    // Pamiętaj o usuwaniu nasłuchiwania zdarzeń po odmontowaniu komponentu
    return () => {
      if (modalElement) {
        modalElement.removeEventListener("shown.bs.modal", shownHandler);
        modalElement.removeEventListener("hidden.bs.modal", hiddenHandler);
      }
    };
  }, [id]);

  return (
    <>
      <div
        class="modal fade"
        id={id}
        data-bs-backdrop="static"
        data-bs-keyboard="false"
        tabindex="-1"
        aria-labelledby="staticBackdropLabel"
        aria-hidden="true"
        ref={modalRef}
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="staticBackdropLabel">
                Modal title
              </h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">{content}</div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
                ref={closeRef}
              >
                Close
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export function EditPopupTrigger({ variant, className }) {
  return (
    <button
      type="button"
      className={"btn btn-primary " + className}
      data-bs-toggle="modal"
      data-bs-target={"#" + id}
      style={{
        width: "50px",
        height: "50px",
      }}
      variant={variant}
      onClick={() => {
        currentVariant = variant;
      }}
    >
      <img src={editIcon} alt="Edytuj" />
    </button>
  );
}
