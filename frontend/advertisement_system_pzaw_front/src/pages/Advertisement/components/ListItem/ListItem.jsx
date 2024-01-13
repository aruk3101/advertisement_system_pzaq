export default function ListItem({text, svg}){
    return <div className='d-flex m-2 align-items-center'>
        <span className='me-2 m-1'>
          {svg}
        </span>
        <span className='text-black'>
          {text}
        </span>
    </div>
  }