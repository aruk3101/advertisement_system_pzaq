export default function Select({
  name,
  value,
  handleChange,
  placeholder = "Enter data",
  feedback = "Please provide valid data.",
  required = "",
  options,
}) {
  return (
    <div class="form-floating mb-3">
      <select
        name={name}
        id={name}
        onChange={handleChange}
        className="form-control"
        placeholder={placeholder}
        value={value}
        required={required}
      >
        {options.map((option) => {
          return <option value={option.value}>{option.name}</option>;
        })}
      </select>
      <label for={name}>{placeholder}</label>
      <div class="invalid-feedback">{feedback}</div>
    </div>
  );
}
