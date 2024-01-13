import { Link } from "react-router-dom";

export default function SimiliarOffer({offer}){
    return (
      <Link to="#" className='text-decoration-none text-black'>
        <div>
          <span className='fs-4'>{offer.position}</span>
          <br/>
          <span className='fs-6'>{offer.company.name}</span>
          <br/>
          <span className='smaller-font-1 text-secondary'>{offer.category}</span>
          <br/>
          <span className='smaller-font-1'>
            {offer.salaryFrom}PLN - {offer.salaryTo}PLN
          </span>
        </div>
        <hr/>
      </Link>
    )
  }