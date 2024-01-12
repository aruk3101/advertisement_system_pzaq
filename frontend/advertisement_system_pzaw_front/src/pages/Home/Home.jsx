import './Home.css';
import defaultCompanyIcon from "assets/images/defaultCompanyPfp.png";
import landingPageImg2 from "assets/images/landing-page-img-2.png";

function Home() {
  
  let nowosci = [
    {
      index:0,
      position:"Position",
      company:{
        imgSrc:defaultCompanyIcon,
        name:"Company name"
      },
      category:"Category",
      jobType : "Job type",
      positionLevel : "Job type",
      workingTimeType : "Job type",
      ContractType : "Job type",
      salaryFrom:4000,
      salaryTo:8000,
    },
    {
      index:1,
      position:"Position",
      company:{
        imgSrc:defaultCompanyIcon,
        name:"Company name"
      },
      category:"Category",
      jobType : "Job type",
      positionLevel : "Job type",
      workingTimeType : "Job type",
      ContractType : "Job type",
      salaryFrom:4000,
      salaryTo:8000,
    },
    {
      index:2,
      position:"Position",
      company:{
        imgSrc:defaultCompanyIcon,
        name:"Company name"
      },
      category:"Category",
      jobType : "Job type",
      positionLevel : "Job type",
      workingTimeType : "Job type",
      ContractType : "Job type",
      salaryFrom:4000,
      salaryTo:8000,
    },
    {
      index:3,
      position:"Position",
      company:{
        imgSrc:defaultCompanyIcon,
        name:"Company name"
      },
      category:"Category",
      jobType : "Job type",
      positionLevel : "Job type",
      workingTimeType : "Job type",
      ContractType : "Job type",
      salaryFrom:4000,
      salaryTo:8000,
    },
  ]


  return (
    <div>
      <div className='bg-primary'>
        <div className='container-md text-white p-3'>
          <div className='row p-1 p-sm-2 p-md-3'>
            <div className='col-12 col-md-7 p-0 p-sm-1 p-md-2 d-flex flex-column align-items-center align-items-md-start'>
              <h1 className='mb-4 fs-3 fs-md-1 text-center text-md-start'>
                Dołącz do 1 000 000 osób, które znalazły pracę !
              </h1>
              <h4 className='mb-3 fs-5 fs-md-4 text-md-start text-center'>
                I szukaj wymarzonego stanowiska spośród 100 000 ofert!
              </h4>
              <h5>
                <ul>
                  <li className='mb-2 fs-6 fs-md-5'>Na naszej stronie oferty pracy umieszcza 50 000 pracodawców!</li>
                  <li className='mb-2 fs-6 fs-md-5'>9/10 użytkowników znalazło pracę!</li>
                  <li className='mb-2 fs-6 fs-md-5'>Nasze usługi znalazły swoich zwolenników również za granicą!</li>
                </ul>
              </h5> 
            </div>
            <div className='col-0 col-md-5 '>
              <img className='d-none d-md-block img-fluid mx-auto d-block' src={landingPageImg2}/>
            </div>
          </div>
        </div>
      </div>
      <div className='home-end bg-primary rounded-bottom-circle'>
      </div>
      <div className='container-md'>
        <div className='row'>
          <div className='col-0 col-md-2'></div>
          <div className='col text-center pt-5 pb-5'>
            <h1>Szukaj ofert pracy</h1> 
            <div className='row'>
              <div className='col-9 p-0'>
                <form className='d-flex me-auto ms-auto'>
                  <input className="form-control form-control-lg rounded-0" type="search" placeholder="Search" aria-label="Search"/>
                  <button className="border btn bg-white rounded-0" type="submit">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                      <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                    </svg>
                  </button>
                </form>
              </div>
              <div className='col-3 p-0'>
                <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                  <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" className="bi bi-filter" viewBox="0 0 16 16">
                    <path d="M6 10.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5m-2-3a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5m-2-3a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11a.5.5 0 0 1-.5-.5"/>
                  </svg>
                </button>
              </div>
            </div>
          </div>
          <div className='col-0 col-md-2'></div>
        </div>
      </div>

      <div className='container-md'>
        <div className='row'>
          <div className='col col-md-6 mb-2'>
            <span className='fs-2 text-center d-block'>Nowości</span>
            <div id="carouselExample" class="carousel slide border border-0 rounded-4 bg-secondary">
              <div class="carousel-inner">
                {nowosci.map((value, index)=>{
                  return <CarouselItemOffer offer = {value} index = {index}/> ; 
                })}
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
          <div className='col col-md-6  mb-2'>
            <span className='fs-2 text-center d-block'>Rekomendowane</span>
            <div id="carouselExample" class="carousel slide border border-0 rounded-4 bg-secondary">
              <div class="carousel-inner">
                {nowosci.map((value, index)=>{
                  return <CarouselItemOffer offer = {value} index = {index}/> ; 
                })}
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
        </div>
      </div>


      <div className="modal fade" tabindex="-1" id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div className="modal-dialog modal-dialog-scrollable">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Filtruj wyniki wyszukiwania !</h5>
              <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div className="modal-body">
              <form>
                i tutaj formularz do filtrowania wyszukiwań na wszystkie możliwe sposoby
              </form>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" className="btn btn-primary">Ten przycisk będzie wysyłać formularz</button>
            </div>
          </div>
        </div>
      </div>


    </div>
  );
}

const CarouselItemOffer = function CarouselItemOffer({offer, index}){
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

export default Home;
