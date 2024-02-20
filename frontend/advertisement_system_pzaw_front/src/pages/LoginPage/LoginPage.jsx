import useLogin from "hooks/useLogin";
import Input from "components/common/Input/Input";
import useForm from "hooks/useForm";
import Submit from "components/common/Submit/Submit";
import Form from "components/common/Form/Form";
import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import SpinnerView from "components/common/SpinnerView/SpinnerView";

export default function LoginPage() {
  const { handleSubmit, Alerts, isLoading } = useLogin();
  const { data, handleChange } = useForm({
    username: "",
    password: "",
  });

  return (
    <div className="container-md">
      <SpinnerView isLoading={isLoading}>
        <div className="row">
          <EmptyGridSpace xs="0" md="3" />
          <Form onSubmit={(event) => handleSubmit(event, data)} className="col">
            <Input
              type="text"
              name="username"
              value={data.username}
              handleChange={handleChange}
              placeholder="Wpisz nazwę użytkownika (email)"
              required="required"
            />
            <Input
              type="password"
              name="password"
              value={data.password}
              handleChange={handleChange}
              placeholder="Wpisz hasło"
              required="required"
            />
            <Submit value="Zaloguj się" />
            <Alerts />
          </Form>
          <EmptyGridSpace xs="0" md="3" />
        </div>
      </SpinnerView>
    </div>
  );
}
