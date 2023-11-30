import './Home.css';

function Home() {
  return (
    <div>
      <div className='bg-primary'>
        <div className='container-md text-white p-3'>
          <div className='row p-4'>
            <div className='col-7 p-2'>
              <h1 className='mb-4'>
                Dołącz do 1 000 000 osób, które znalazły pracę !
              </h1>
              <h4 className='mb-3'>
                I szukaj wymarzonego stanowiska spośród 100 000 ofert!
              </h4>
              <h5>
                <ul>
                  <li className='mb-2'>Na naszej stronie oferty pracy umieszcza 50 000 pracodawców!</li>
                  <li className='mb-2'>9/10 użytkowników znalazło pracę!</li>
                  <li className='mb-2'>Nasze usługi znalazły swoich zwolenników również za granicą!</li>
                </ul>
              </h5>
            </div>
            <div className='col-5'>
              <img src='img/landing-page-img-2.png'/>
            </div>
          </div>
        </div>
      </div>
      <div className='home-end bg-primary rounded-bottom-circle d-none d-md-block'>
      </div>
      <div className='container-md'>
        <div className='row'>
          <div className='col text-center pt-5 pb-5'>
            <h1>Szukaj ofert pracy</h1>
            I tutaj jakiś formularz do wyszkiuwania
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
