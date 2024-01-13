import './Advertisement.css';
import { useParams } from 'react-router-dom';
import 'assets/css/fonts.css'
import 'assets/css/profilePicture.css'
import NavigationCard from 'components/NavigationCard/NavigationCard';
import Position from './components/Position/Position';
import Localization from './components/Localization/Localization';
import Responsibilities from './components/Responsibilities/Responsibilites';
import Requirements from './components/Requirements/Requirements';
import Opportunities from './components/Opportunities/Opportunities';
import AdvertisementUuid from './components/AdvertisementUuid/AdvertisementUuid';
import ApplyButton from './components/ApplyButton/ApplyButton';
import SimiliarOffersCard from './components/SimiliarOffersCard/SimiliarOffersCard';
import { shadeColor } from 'utils/color';

function Advertisement() {
    let { id } = useParams();
    let iframeLink = "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2580.634152096076!2d20.4174095109076!3d49.698861941076736!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47161cd0d7dfe0e5%3A0x8b8e90f28d06c112!2zWmVzcMOzxYIgU3prw7PFgiBUZWNobmljem55Y2ggaSBPZ8OzbG5va3N6dGHFgmNhY3ljaCBpbS4gSmFuYSBQYXfFgmEgSUk!5e0!3m2!1spl!2spl!4v1703878046643!5m2!1spl!2spl";
    let color;

    let responsibilites = [
      {name: "Responsibility 1"},
      {name: "Responsibility 2"},
      {name: "Responsibility 3"},
      {name: "Responsibility 4"},
      {name: "Responsibility 5"},
      {name: "Responsibility 6"},
      {name: "Responsibility 7"},
    ]
    let requirements = [
      {name: "Requirement 1"},
      {name: "Requirement 2"},
      {name: "Requirement 3"},
      {name: "Requirement 4"},
      {name: "Requirement 5"},
      {name: "Requirement 6"},
      {name: "Requirement 7"},
    ]
    let opportunities = [
      {name: "Opportunity 1"},
      {name: "Opportunity 2"},
      {name: "Opportunity 3"},
      {name: "Opportunity 4"},
      {name: "Opportunity 5"},
      {name: "Opportunity 6"},
      {name: "Opportunity 7"},
    ]
    if(color == null ){
      color = "#0dccf2";
    }
    // kolor będzie można wybrać przy tworzeniu ogłoszenia i przekazywny tutaj z api
    document.documentElement.style.setProperty("--custom_color", color);
    document.documentElement.style.setProperty("--custom_color_dark", shadeColor(color, -40));
  return (
    <div className='bg-primary-subtle'>
      <div className='container gx-5 gy-2 p-1 p-sm-2 p-md-4'>
        <div className='row'>
          <div className='col-12 col-xl-9'>
            <Position/>
            <NavigationCard data={
               [
                {href:"#stanowisko", header:"Stanowisko"},
                {href:"#lokalizacja", header:"Lokalizacja"},
                {href:"#obowiazki", header:"Obowiązki"},
                {href:"#wymagania", header:"Wymagania"},
                {href:"#benefity", header:"Benefity, możliwości"},
              ]
            }/>
            <Localization iframeLink={iframeLink}/>
            <Responsibilities responsibilites={responsibilites}/>
            <Requirements requirements={requirements}/>
            <Opportunities opportunities={opportunities}/>
            <AdvertisementUuid id={id}/>
          </div>        
          <div className='col-12 col-xl-3 position-relative'> 
            <ApplyButton/>
            <SimiliarOffersCard/>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Advertisement;