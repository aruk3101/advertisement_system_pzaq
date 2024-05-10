import { request } from "./AxiosService";

const BASE_URL = "users/";

function combine(url) {
  return BASE_URL + url;
}

function handleErrors(response) {
  switch (response.status) {
    case 401: //BAD_CREDENTIALS
      return {
        ...response,
        message: "Użytkownik o takich danych nie istnieje!",
      };
    //kolejne przypadki
    default:
      return {
        ...response,
        message:
          "Wystąpił nieokreślony błąd, skontaktuj się z administratorem, lub spróbuj ponownie",
      };
  }
}

export function EditUserData(data) {
  return request({
    method: "put",
    url: combine("account"),
    data: data,
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}
