import landingPageImg2 from "assets/images/landing-page-img-2.png";
import "./LandingContent.css";

const Header = ()=>{
    return (
        <h1 className='mb-4 fs-3 fs-md-1 text-center text-md-start'>
            Dołącz do 1 000 000 osób, które znalazły pracę !
        </h1>
    )
}

const SubHeader = () =>{
    <h4 className='mb-3 fs-5 fs-md-4 text-md-start text-center'>
        I szukaj wymarzonego stanowiska spośród 100 000 ofert!
    </h4>
}

const List = ({children}) =>{
    return (
        <h5>
            <ul>
                {children}
            </ul>
        </h5> 
    )  
}

const ListItem = ({children}) =>{
    return (
        <li className='mb-2 fs-6 fs-md-5'>
            {children}
        </li>
    )
}

const LandingImage = () =>{
    return (
        <div className='col-0 col-md-5 '>
            <img className='d-none d-md-block img-fluid mx-auto d-block' src={landingPageImg2}/>
        </div>
    )
}

export default function LandingContent() {
    return (
        <>
            <div className='bg-primary'>
                <div className='container-md text-white p-3'>
                    <div className='row p-1 p-sm-2 p-md-3'>
                        <div className='col-12 col-md-7 p-0 p-sm-1 p-md-2 d-flex flex-column align-items-center align-items-md-start'>
                            <Header/>
                            <SubHeader/>
                            <List>
                                <ListItem>Na naszej stronie oferty pracy umieszcza 50 000 pracodawców!</ListItem>
                                <ListItem>9/10 użytkowników znalazło pracę!</ListItem>
                                <ListItem>Nasze usługi znalazły swoich zwolenników również za granicą!</ListItem>
                            </List>
                        </div>
                        <LandingImage/>
                    </div>
                </div>
            </div>
            <div className='home-end bg-primary rounded-bottom-circle'/>
        </>
    )
}