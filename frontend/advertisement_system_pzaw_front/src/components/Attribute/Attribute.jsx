import './Attribute.css';
import "assets/css/fonts.css";

function Attribute(props) {
    return(
        <div className='d-flex align-items-center m-2'>
            <div className='rounded d-inline-block bg-secondary-subtle me-2'>
              <div className='p-2'>
                {props.svgIcon}
              </div>
            </div>
            <div className='d-inline-block'>
              <span className='smaller-font-1'>{props.header}</span>
              {props.subHeader == null ? "" : <><br/><span className='smaller-font-2 text-secondary'>{props.subHeader}</span></>}
            </div>
        </div>
      )
}

export default Attribute;
