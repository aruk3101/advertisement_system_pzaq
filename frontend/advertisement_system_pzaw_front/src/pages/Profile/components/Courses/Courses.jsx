import Card from "components/common/Card/Card";
import ListElement from "../ListElement/ListElement";

export default function Courses(){
    return (
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
                  return <ListElement
                    h1 = {value.name}
                    h2 = {value.host}
                    date = {value.date}
                  />
                })
              }
            </ul>
        </Card>
    )
}