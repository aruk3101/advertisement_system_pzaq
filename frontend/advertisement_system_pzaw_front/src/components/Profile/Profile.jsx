import { Link } from 'react-router-dom';
import './Profile.css';
import Card from "components/Card/Card"
import InputGroup from 'components/InputGroup/InputGroup'
import Nav from "components/Nav/Nav";
import 'assets/css/fonts.css'
import 'assets/css/profilePicture.css'

function Profile() {

  return (
    <div className='bg-primary-subtle'>
      <div className='container gx-5 gy-2 p-1 p-sm-2 p-md-4'>
       <div className='row'>
        <div className='col-12 col-xl-9'>
          <Card header = "Imie Nazwisko" beforeContent = {
            <div className=' banner position-relative bg-info rounded-top'>
              <img src='/img/defaultPfp.webp' className='object-fit-cover rounded-circle border border-5 border-info position-absolute pfp' width={200} height={200}/>
            </div>
          }>
            <span>
              34-600 Limanowa, &nbsp;
            </span>
            <span>
            PL
            </span>
          </Card>

          <Card header = "Nawigacja" bootstrapFontsize="fs-4">
            <Nav content={
              [
                {href:"#stanowisko", header:"Aktualne Stanowisko Pracy"},
                {href:"#podsumowanie", header:"Podsumowanie zawodowe"},
                {href:"#wyksztalcenie", header:"Wykształcenie"},
                {href:"#umiejetnosci", header:"Umiejętności"},
                {href:"#kursy", header:"Certyfikaty"},
                {href:"#daneKontaktowe", header:"Dane Kontaktowe"},
                {href:"#danePersonalne", header:"Dane Personalne"},
                {href:"#jezyki", header:"Języki"},
                {href:"#linki", header:"Linki"},
              ]
            }/>
          </Card>

          <Card header = "Aktualne Stanowisko Pracy" id="stanowisko">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tincidunt dui sed volutpat porttitor. Donec vulputate condimentum convallis. Curabitur at urna ac lacus hendrerit mattis. Sed nunc dui, aliquam vitae tempor sed, auctor sed lorem. Morbi posuere vestibulum mollis. Sed maximus varius ipsum vitae ornare. Nunc aliquam lectus eget ex accumsan, vitae dignissim nibh ornare. Morbi gravida nisi vitae urna aliquam dapibus. Aenean eleifend eu erat nec maximus.
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tincidunt dui sed volutpat porttitor. Donec vulputate condimentum convallis. Curabitur at urna ac lacus hendrerit mattis. Sed nunc dui, aliquam vitae tempor sed, auctor sed lorem. Morbi posuere vestibulum mollis. Sed maximus varius ipsum vitae ornare. Nunc aliquam lectus eget ex accumsan, vitae dignissim nibh ornare. Morbi gravida nisi vitae urna aliquam dapibus. Aenean eleifend eu erat nec maximus.
          </Card>

          <Card header = "Podsumowanie zawodowe" id="podsumowanie">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tincidunt dui sed volutpat porttitor. Donec vulputate condimentum convallis. Curabitur at urna ac lacus hendrerit mattis. Sed nunc dui, aliquam vitae tempor sed, auctor sed lorem. Morbi posuere vestibulum mollis. Sed maximus varius ipsum vitae ornare. Nunc aliquam lectus eget ex accumsan, vitae dignissim nibh ornare. Morbi gravida nisi vitae urna aliquam dapibus. Aenean eleifend eu erat nec maximus.
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer tincidunt dui sed volutpat porttitor. Donec vulputate condimentum convallis. Curabitur at urna ac lacus hendrerit mattis. Sed nunc dui, aliquam vitae tempor sed, auctor sed lorem. Morbi posuere vestibulum mollis. Sed maximus varius ipsum vitae ornare. Nunc aliquam lectus eget ex accumsan, vitae dignissim nibh ornare. Morbi gravida nisi vitae urna aliquam dapibus. Aenean eleifend eu erat nec maximus.
          </Card>

          <Card header = "Wykształcenie" id="wyksztalcenie">
            <ul class="list-group list-group-flush">
              <Element
                h1 = "Nazwa Szkoły"
                h2 = "Specjalizacja"
                location = "Adres szkoły"
                period_start = "03.2020"
                period_end = "09.2022"
                level = "Podstawowe"              
              />
               <Element
                h1 = "Nazwa Szkoły"
                h2 = "Specjalizacja"
                location = "Adres szkoły"
                period_start = "03.2020"
                period_end = "09.2022"
                level = "Podstawowe"              
              />
               <Element
                h1 = "Nazwa Szkoły"
                h2 = "Specjalizacja"
                location = "Adres szkoły"
                period_start = "03.2020"
                period_end = "09.2022"
                level = "Podstawowe"              
              />
            </ul>
          </Card>

          <Card header = "Doświadczenie" id="doswiadczenie">
            <ul class="list-group list-group-flush">
              <Element
                h1 = "Przedsiębiorstwo"
                h2 = "Stanowisko"
                location = "Adres siedziby firmy"
                period_start = "03.2020"
                period_end = "09.2022"
                duties = {[
                  "Duty 1",
                  "Duty 2",
                  "Duty 3",
                  "max character duty max character duty max character duty max character duty max character duty max c",
                  "Duty 5",
                ]}           
              />
               <Element
                h1 = "Przedsiębiorstwo"
                h2 = "Stanowisko"
                location = "Adres siedziby firmy"
                period_start = "03.2020"
                period_end = "09.2022"
                duties = {[
                  "Duty 1",
                  "Duty 2",
                  "Duty 3",
                  "Duty 4",
                  "Duty 5",
                ]}           
              />
            </ul>
          </Card>

          <Card header = "Umiejętności" id="umiejetnosci">
            <ul class="list-group list-group-flush">
              {
                [ //tutaj będzie odpowiedź z rest api 
                  {
                    "skill_name" : "Skill 1"
                  },
                  {
                    "skill_name" : "Skill 2"
                  },
                  {
                    "skill_name" : "Skill 3"
                  },
                  {
                    "skill_name" : "max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill "
                  },
                  {
                    "skill_name" : "Skill 5"
                  },
                ].map((value) => {
                    return (
                      <li className='list-group-item'>
                          {value.skill_name}
                      </li>
                    )
                })
              }
            </ul>
          </Card>

          <Card header = "Kursy, szkolenia itp." id="kursy">
            <ul class="list-group list-group-flush">
              {
                [
                  {
                    "name" : "Nazwa certyfikatu / szkolenia",
                    "host" : "Organizator",
                    "date" : "data, np. 02.12.2023"
                  },
                  {
                    "name" : "Nazwa certyfikatu / szkolenia",
                    "host" : "Organizator",
                    "date" : "data, np. 02.12.2023"
                  },
                  {
                    "name" : "Nazwa certyfikatu / szkolenia",
                    "host" : "Organizator",
                    "date" : "data, np. 02.12.2023"
                  }
                ].map((value)=>{
                  return <Element
                    h1 = {value.name}
                    h2 = {value.host}
                    date = {value.date}
                  />
                })
              }
            </ul>
          </Card>
          <Card>
          </Card>
          
        </div>        
        <div className='col-12 col-xl-3 position-relative'> 
          <Card header = "Dane Kontaktowe" bootstrapFontsize = "fs-5" headerCenter = "text-center" id="daneKontaktowe">
            <InputGroup
              id="basic-addon1"
              firstElement = {
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                  <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"/>
                </svg>
              }
              aria_label="Telephone"
              value = "123 456 789"
            />
            <InputGroup
              id="basic-addon2"
              firstElement = {
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
                  <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
                </svg>
              }
              aria_label="Email"
              value = "mail@mail.com"
            />
          </Card>
          
          <Card header = "Dane Personalne" bootstrapFontsize = "fs-5" headerCenter = "text-center" id="danePersonalne">
            <InputGroup
              id="basic-addon3"
              firstElement = {
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                  <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
                </svg>
              }
              aria_label="Address"
              value = "Mordarka xxx"
            />
            <InputGroup
              id="basic-addon4"
              firstElement = {
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cake-fill" viewBox="0 0 16 16">
                  <path d="m7.399.804.595-.792.598.79A.747.747 0 0 1 8.5 1.806V4H11a2 2 0 0 1 2 2v3h1a2 2 0 0 1 2 2v4a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1v-4a2 2 0 0 1 2-2h1V6a2 2 0 0 1 2-2h2.5V1.813a.747.747 0 0 1-.101-1.01ZM12 6.414a.911.911 0 0 1-.646-.268 1.914 1.914 0 0 0-2.708 0 .914.914 0 0 1-1.292 0 1.914 1.914 0 0 0-2.708 0A.911.911 0 0 1 4 6.414v1c.49 0 .98-.187 1.354-.56a.914.914 0 0 1 1.292 0c.748.747 1.96.747 2.708 0a.914.914 0 0 1 1.292 0c.374.373.864.56 1.354.56zm2.646 5.732a.914.914 0 0 1-1.293 0 1.914 1.914 0 0 0-2.707 0 .914.914 0 0 1-1.292 0 1.914 1.914 0 0 0-2.708 0 .914.914 0 0 1-1.292 0 1.914 1.914 0 0 0-2.708 0 .914.914 0 0 1-1.292 0L1 11.793v1.34c.737.452 1.715.36 2.354-.28a.914.914 0 0 1 1.292 0c.748.748 1.96.748 2.708 0a.914.914 0 0 1 1.292 0c.748.748 1.96.748 2.707 0a.914.914 0 0 1 1.293 0 1.915 1.915 0 0 0 2.354.28v-1.34l-.354.354Z"/>
                </svg>
              }
              aria_label="BirthDate"
              value = "01.01.1990"
            />
          </Card>

          <Card header = "Języki" bootstrapFontsize = "fs-5" headerCenter = "text-center" id="jezyki">
            {[
              {
                "language" : "Angielski",
                "level" : "C2"
              },
              {
                "language" : "Niemiecki",
                "level" : "B1"
              },
              {
                "language" : "Francuski",
                "level" : "A1"
              },
            ].map((value, index) => { 
              return (
                <InputGroup
                  id={"language-addon-" + index}
                  firstElement = {
                    value.level
                  }
                  aria_label={"language-addon-" + index}
                  value = {value.language}
                />
              )
            })}
          </Card>

          <Card header = "Linki" bootstrapFontsize = "fs-5" headerCenter = "text-center" id="linki">
            <ul className='list-group list-group-flush'>
              <li className='list-group-item'>
                <Link className='text-decoration-none text-center' to={"/"}>Github</Link>
              </li>
              <li className='list-group-item'>
                <Link className='text-decoration-none text-center' to={"/"}>Linkedin</Link>
              </li>
              <li className='list-group-item'>
                <Link className='text-decoration-none text-center' to={"/"}>Facebook</Link>
              </li>
            </ul>
          </Card>
        </div>
       </div>
      </div>
    </div>
  );
}

export default Profile;

function Element(props){

  return (
    <li class="list-group-item">
      <h1 className='fs-5 mb-0'>
        {props.h1}
      </h1>
      <h2 className='fs-6 mb-0'>
        {props.h2}
      </h2>
        <span className='smaller-font-1 text-black-50'>
          {
            props.date == null ? 
              props.location + ", " + props.period_start + " - " + props.period_end
              :
              "Data uzyskania : " + props.date
          } 
        </span>
      
     
      {props.level == null ? "" : 
        <h3 className='fs-5 mt-2 mb-0 d-flex align-items-center'>
          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-book me-2" viewBox="0 0 16 16">
            <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783"/>
          </svg>
          {props.level}
        </h3>
      }
      {props.duties == null ? "" : 
        <div>
          <h4 className = "fs-5 mb-0">Obowiązki: </h4>
          <ul className='duties'>
            {props.duties.map((value) => {
              return <li>{value}</li>
            })}
          </ul>
        
        </div>
      }
      
    </li>
  )
}
