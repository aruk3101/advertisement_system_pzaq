import "./CarouselItemOffer.css";

export default function CarouselItemOffer({offer}){
    return (
      <div className={'carousel-item w-100 h-100 ' + ((offer.index==0)?" active " : "")
      }>
        <div className='d-flex ms-5 me-5 align-items-center text-center text-md-start'>
          <div className='d-none d-md-block'>
            <img src={offer.company.imgSrc} width="100" height="100"/>
          </div>
          <div className='ms-md-0 me-md-0 ms-5 me-5'>
            <span className='fs-4'>{offer.position}</span>
            <br/>
            <span className='fs-6'>{offer.company.name}</span>
            <br/>
            <span className='smaller-font-1 text-black'>
              {offer.salaryFrom}PLN - {offer.salaryTo}PLN
            </span>
            <br/>
            <span className=''>
              <span class="badge bg-primary m-1">{offer.jobType}</span>
              <span class="badge bg-primary m-1">{offer.workingTimeType}</span>
              <span class="badge bg-primary m-1">{offer.positionLevel}</span>
              <span class="badge bg-primary m-1">{offer.workingTimeType}</span>
            </span>
          </div>
        </div>
      </div>
    )
}