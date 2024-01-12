import { Children } from 'react';
import './Footer.css';
import { Link } from "react-router-dom"

function Footer(props) {
  return (
    <div className={'footer bg-secondary ' + (props.className ?? "")}>
      <div className='container-md g-0'>
      <div className={'row  w-100 g-0 '}> 
        <div className='col d-flex flex-column flex-md-row g-md-4 justify-content-center'>
          <Column id="footer-1" header="Header">
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
          </Column>
          <Column id="footer-2" header="Header">
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
          </Column>
          <Column id="footer-3" header="Header">
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
            <Link to="#" className='link-dark text-decoration-none'>Some link</Link>
          </Column>
        </div>
      </div>
      <div className='row g-0'>
        <div className="text-center g-0 p-3">
          Wykonano przez : Damian Raczek ®    
        </div>
      </div>
      </div>
      
    </div>
  );
}

function Column(props) {

  window.addEventListener("resize", function() {
    if(this.window.innerWidth >= 768){
      this.document.querySelectorAll(".footer .accordion-collapse").forEach(element => {
        if(!element.classList.contains("show")){
          element.classList.add("show");
        }
      });
    }
  })

  let accordionId = "accordion" + props.id;
  let collapseId = "collapse" + props.id;
  return (
    <div class="accordion accordion-flush col-12 col-md-4 p-0 p-md-4" id={accordionId}>
      <div class="accordion-item bg-transparent">
        <h2 class="accordion-header d-md-none">
          <button class="accordion-button collapsed bg-secondary-subtle" type="button" data-bs-toggle="collapse" data-bs-target={"#" + collapseId} aria-expanded="false" aria-controls={collapseId}>
            {props.header}
          </button>
        </h2>
        <div id={collapseId} class="accordion-collapse" data-bs-parent={"#" + accordionId}>
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
