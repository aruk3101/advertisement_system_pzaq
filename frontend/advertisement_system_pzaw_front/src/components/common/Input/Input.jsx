import "./Input.css";

export default function Input({
  type,
  name,
  value,
  handleChange,
  placeholder = "Enter data",
  feedback = "Please provide valid data.",
  required = "",
  pattern,
}) {
  return (
    <div class="form-floating mb-3">
      <input
        type={type}
        name={name}
        id={name}
        onChange={handleChange}
        className="form-control"
        placeholder={placeholder}
        value={value}
        required={required}
        pattern={pattern && pattern}
      />
      <label for={name}>{placeholder}</label>
      <div class="invalid-feedback">{feedback}</div>
    </div>
  );
}
