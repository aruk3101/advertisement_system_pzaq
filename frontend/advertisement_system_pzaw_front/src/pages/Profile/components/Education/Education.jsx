import Card from "components/common/Card/Card";
import ListElement from "../ListElement/ListElement";

export default function Education(){
    return (
        <Card header = "Wykształcenie" id="wyksztalcenie">
            <ul class="list-group list-group-flush">
              <ListElement
                h1 = "Nazwa Szkoły"
                h2 = "Specjalizacja"
                location = "Adres szkoły"
                period_start = "03.2020"
                period_end = "09.2022"
                level = "Podstawowe"              
              />
               <ListElement
                h1 = "Nazwa Szkoły"
                h2 = "Specjalizacja"
                location = "Adres szkoły"
                period_start = "03.2020"
                period_end = "09.2022"
                level = "Podstawowe"              
              />
               <ListElement
                h1 = "Nazwa Szkoły"
                h2 = "Specjalizacja"
                location = "Adres szkoły"
                period_start = "03.2020"
                period_end = "09.2022"
                level = "Podstawowe"              
              />
            </ul>
        </Card>
    )
}