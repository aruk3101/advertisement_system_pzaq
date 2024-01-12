import Card from "components/common/Card/Card";
import Nav from "components/common/Nav/Nav";

export default function NavigationCard({data}){
    return(
        <Card header = "Nawigacja" bootstrapFontsize="fs-4">
            <Nav content={data}/>
        </Card>
    )
}