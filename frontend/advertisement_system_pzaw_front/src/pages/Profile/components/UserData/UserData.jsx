import defaultPfpIcon from "assets/images/defaultPfp.webp";
import Card from "components/common/Card/Card";

export default function UserData(){
    return (
        <Card header = "Imie Nazwisko" beforeContent = {
            <div className=' banner position-relative bg-info rounded-top'>
              <img src={defaultPfpIcon} className='object-fit-cover rounded-circle border border-5 border-info position-absolute pfp' width={200} height={200}/>
            </div>
          }>
          <span>
            34-600 Limanowa, &nbsp;
          </span>
          <span>
          PL
          </span>
        </Card>
    )
}