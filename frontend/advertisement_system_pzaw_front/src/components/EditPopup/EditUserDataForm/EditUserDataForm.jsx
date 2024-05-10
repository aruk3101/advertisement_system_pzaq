import { useUser } from "hooks/useUser";
import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import useEditUserData from "hooks/useEditUserData";

export default function EditUserDataForm({ forceClose }) {
  const { user } = useUser();
  const { account } = user;
  const { address } = account;
  console.log(account);
  const { handleSubmit, Alerts, isLoading } = useEditUserData();
  const { data, handleChange } = useForm({
    firstName: account.firstName,
    lastName: account.lastName,
    birthDate: account.birthDate,
    phoneNumber: account.phoneNumber,
    city: address.city,
    postalName: address.postalName,
    postalCode: address.postalCode,
    street: address.street,
    streetNumber: address.streetNumber,
    apartmentNumber: address.apartmentNumber,
    country: address.country,
    addressVersion: address.version,
    careerSummary: account.careerSummary,
    currentPosition: account.currentPosition,
    version: account.version,
  });
  return (
    <div className="container-md">
      <SpinnerView isLoading={isLoading}>
        <div className="row">
          <EmptyGridSpace xs="0" md="1" />
          <Form
            className="col"
            method="post"
            onSubmit={(event) => handleSubmit(event, data, forceClose)}
          >
            <Input
              placeholder="Imie"
              name="firstName"
              type="text"
              id="firstName"
              value={data["firstName"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Nazwisko"
              name="lastName"
              type="text"
              id="lastName"
              value={data["lastName"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Data urodzenia"
              name="birthDate"
              type="date"
              id="birthDate"
              value={data["birthDate"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Numer telefonu"
              name="phoneNumber"
              type="tel"
              id="phoneNumber"
              value={data["phoneNumber"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Podsumowanie zawodowe"
              name="careerSummary"
              type="text"
              id="careerSummary"
              value={data["careerSummary"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Aktualne stanowisko"
              name="currentPosition"
              type="text"
              id="currentPosition"
              value={data["currentPosition"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Miejscowość"
              name="city"
              type="text"
              id="city"
              value={data["city"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Miasto"
              name="postalName"
              type="text"
              id="postalName"
              value={data["postalName"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Kod pocztowy"
              name="postalCode"
              type="text"
              id="postalCode"
              value={data["postalCode"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Ulica"
              name="street"
              type="text"
              id="street"
              value={data["street"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Numer domu"
              name="streetNumber"
              type="text"
              id="streetNumber"
              value={data["streetNumber"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="lokal"
              name="apartmentNumber"
              type="text"
              id="apartmentNumber"
              value={data["apartmentNumber"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Państwo"
              name="country"
              type="text"
              id="country"
              value={data["country"]}
              handleChange={handleChange}
              required="required"
            />
            <Submit value="Prześlij" />
            <Alerts />
          </Form>
          <EmptyGridSpace xs="0" md="1" />
        </div>
      </SpinnerView>
    </div>
  );
}
