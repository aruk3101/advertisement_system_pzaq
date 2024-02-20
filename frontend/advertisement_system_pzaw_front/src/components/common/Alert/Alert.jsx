export default function ({ variant = "primary", message }) {
  return (
    <div class={"alert show" + (variant && " alert-" + variant)} role="alert">
      {message}
    </div>
  );
}
