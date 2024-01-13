import ListElement from "../ListElement/ListElement";
import Card from "components/common/Card/Card";

export default function Experience(){
    return (
        <Card header = "Doświadczenie" id="doswiadczenie">
            <ul class="list-group list-group-flush">
              <ListElement
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
               <ListElement
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
    )
}