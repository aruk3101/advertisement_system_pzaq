import './Nav.css';

function Nav(props){
    return(
      <div className='row'>
          <div className='col p-1'>
            {render(props.content)}
          </div>
      </div>
    )
  
    function render(content){
      return (
      <div className='d-flex flex-wrap'>
        {
          content.map((value, index)=>{
            let limiter = ((index != content.length-1) ? <span className="text-black fs-4">&nbsp;|&nbsp;</span> : "");
            return <><NavLink href = {value.href} header ={value.header}/>{limiter}</>
          })
        }
      </div>)
    }

    function NavLink(props){
        return( /* <a> zamiast <Link> bo <Link> nie przenosi po id na daną sekcje strony */
          <a href={props.href} className='m-2 text-decoration-none d-inline'>
            {props.header}
          </a>
        )
      }
}

export default Nav;
