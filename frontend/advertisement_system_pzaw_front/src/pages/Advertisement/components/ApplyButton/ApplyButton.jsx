import Card from "components/common/Card/Card";
import { Link } from "react-router-dom";

export default function ApplyButton(){
    return (
        <Card>
            <Link to="#" className=' text-decoration-none text-white bg-custom-dark p-2 d-block text-center fs-3 border border-0 rounded-4'>Aplikuj</Link>
        </Card>
    )
}