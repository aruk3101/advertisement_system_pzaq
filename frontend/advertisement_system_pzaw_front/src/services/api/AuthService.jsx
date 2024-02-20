import { request } from "./AxiosService";

const BASE_URL = "auth/";

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

export function Login(username, password) {
  return request({
    method: "post",
    url: combine("login"),
    data: {
      username: username,
      password: password,
    },
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function Register(username, password, confirmPassword) {
  return request({
    method: "post",
    url: combine("register"),
    data: {
      username: username,
      password: password,
      confirmPassword: confirmPassword,
    },
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function Activate(token) {
  console.log(token);
  return request({
    method: "post",
    url: combine("activate"),
    data: token,
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}
