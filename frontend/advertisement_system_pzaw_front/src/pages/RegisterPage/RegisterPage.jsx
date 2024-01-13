import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace"
import useRegister from "hooks/useRegister"
import useForm from "hooks/useForm"
import Form from "components/common/Form/Form"
import Input from "components/common/Input/Input"
import Submit from "components/common/Submit/Submit"
import SpinnerView from "components/common/SpinnerView/SpinnerView"

export default function RegisterPage(){

    const {handleSubmit, Alerts, isLoading} = useRegister();
    const {data, handleChange} = useForm(
        {
            "username" : "",
            "password" : "",
            "confirmPassword":""
        }
    );
    return (
        <div className="container-md">
            <SpinnerView isLoading = {isLoading}>
                <div className="row">
                    <EmptyGridSpace xs="0" md="3"/>
                    <Form className="col" method="post" onSubmit={(event)=>handleSubmit(event, data)}>
                        <Input placeholder="email" name="username" type="email" id="email" value={data['username']} handleChange={handleChange} required="required"/>
                        <Input placeholder="password" name="password" type="password" id="password"  value={data['password']}  handleChange={handleChange} required="required"/>             
                        <Input placeholder="Repeat password" name="confirmPassword" type="password" id="confirmPassword" value={data['confirmPassword']} handleChange={handleChange} required="required"/>             
                        <Submit value="Prześlij" />
                        <Alerts/>
                    </Form>
                    <EmptyGridSpace xs="0" md="3"/>
                </div>
            </SpinnerView>
            
        </div>
    )
}