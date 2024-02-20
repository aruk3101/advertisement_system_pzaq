import { useEffect, useRef } from "react";

export default function Form(props) {
  const form = useRef();
  useEffect(() => {
    form.current.addEventListener("submit", (event) => {
      if (!form.current.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }
      form.current.classList.add("was-validated");
    });
  }, []);

  return (
    <form {...props} ref={form} noValidate>
      {props.children}
    </form>
  );
}
