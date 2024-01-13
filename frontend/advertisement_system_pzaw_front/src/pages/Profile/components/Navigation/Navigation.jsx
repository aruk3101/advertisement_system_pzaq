import NavigationCard from "components/NavigationCard/NavigationCard"

export default function Navigation(){
    return (
       <NavigationCard data={
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
    )
}