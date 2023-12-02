import './InputGroup.css';

function InputGroup(props){
    return (
      <div class="input-group pt-3">
        <span class="input-group-text" id={props.id ?? "default"}>
          {props.firstElement ?? "*"}
        </span>
        <input type="text" class="form-control" aria-label={props.aria_label ?? ""} aria-describedby={props.id ?? "default"} disabled value={props.value ?? ""}/>
      </div>
    )
  }

export default InputGroup;
