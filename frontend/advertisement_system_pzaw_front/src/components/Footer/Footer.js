import { Children } from 'react';
import './Footer.css';
import { Link } from "react-router-dom"

function Footer(props) {
  return (
    <>
      <div className={'row bg-secondary w-100 g-0' + (props.className ?? "")}> 
        <div className='col d-flex flex-column flex-md-row g-md-4 justify-content-center'>
          <Column id="footer-1" header="Header">
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
          </Column>
          <Column id="footer-2" header="Header">
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
          </Column>
          <Column id="footer-3" header="Header">
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
            <Link to="#">Some link</Link>
          </Column>
        </div>
      </div>
      <div className='row g-0'>
        <div className="text-center g-0 p-3 bg-secondary bg-gradient">
          Wykonano przez : Damian Raczek ®    
        </div>
      </div>
    </>
  );
}

function Column(props) {
  let accordionId = "accordion" + props.id;
  let collapseId = "collapse" + props.id;
  return (
    // <div className="accordion col-12 col-md-4 p-0 p-md-4" id={accordionId}>
    //   <div className="accordion-item">
    //     <h2 className="accordion-header d-md-none">
    //       <button className="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target={"#" + collapseId} aria-expanded="false" aria-controls={collapseId}>
    //         {props.header}
    //       </button>
    //     </h2>
    //     <div id={collapseId} className="accordion-collapse " data-bs-parent={"#" + accordionId}>
    //       <div className="accordion-body d-flex flex-column">
    //         <h4 className='d-none d-md-block'>{props.header}</h4>
    //         {props.children}
    //       </div>
    //     </div>
    //   </div>
    // </div>
    <div class="accordion accordion-flush col-12 col-md-4 p-0 p-md-4" id={accordionId}>
      <div class="accordion-item bg-transparent">
        <h2 class="accordion-header d-md-none">
          <button class="accordion-button collapsed bg-secondary-subtle" type="button" data-bs-toggle="collapse"  data-bs-target={"#" + collapseId} aria-expanded="false" aria-controls={collapseId}>
            {props.header}
          </button>
        </h2>
        <div id={collapseId} class="accordion-collapse collapse show" data-bs-parent={"#" + accordionId}>
          <div class="accordion-body d-flex flex-column">
            <h4 className='d-none d-md-block'>{props.header}</h4>
             {props.children}
          </div>
        </div>
      </div>
    </div>
  )

}

export default Footer;
