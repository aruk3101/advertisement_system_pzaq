import Alert from "../Alert/Alert";

export default function AlertList({errorAlerts}){
    return (
        <div className="my-4">
            {
                errorAlerts.map((value)=>{
                    return (
                        <Alert variant="danger" message={value}/>
                    )
                })
            }
        </div>
    )
}