import './Home.css';
import defaultCompanyIcon from "assets/images/defaultCompanyPfp.png";
import LandingContent from "./components/LandingContent/LandingContent"
import SearchBar from 'components/common/SearchBar/SearchBar';
import Filter from './components/Filter/Filter';
import CarouselItemOffer from './components/CarouselItemOffer/CarouselItemOffer';
import SimpleCarousel from 'components/common/SimpleCarousel/SimpleCarousel';
import EmptyGridSpace from 'components/common/EmptyGridSpace/EmptyGridSpace';

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
      <LandingContent/>
      <div className='container-md'>
        <div className='row'>
          <EmptyGridSpace md="2" xs="0"/>
          <div className='col text-center pt-5 pb-5'>
            <h1>Szukaj ofert pracy</h1> 
            <div className='row'>
              <div className='col-9 p-0'>
                <SearchBar variant='lg' withBorder="true"/>
              </div>
              <div className='col-3 p-0'>
                <Filter modalId="modal"/>
              </div>
            </div>
          </div>
          <EmptyGridSpace md="2" xs="0"/>
        </div>
      </div>

      <div className='container-md'>
        <div className='row'>
          <div className='col col-md-6 mb-2'>
            <span className='fs-2 text-center d-block'>Nowości</span>
            <SimpleCarousel id="newestCarousel">
              {nowosci.map((value, index)=>{
                return <CarouselItemOffer offer = {value} index = {index}/> ; 
              })}
            </SimpleCarousel>
          </div>
          <div className='col col-md-6 mb-2'>
            <span className='fs-2 text-center d-block'>Rekomendowane</span>
            <SimpleCarousel id="recommendedCarousel">
              {nowosci.map((value, index)=>{
                return <CarouselItemOffer offer = {value} index = {index}/> ; 
              })}
            </SimpleCarousel>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
