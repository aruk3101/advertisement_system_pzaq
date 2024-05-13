import { request } from "./AxiosService";

const BASE_URL = "accountSkills/";

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

export function EditUserSkill(data, uuid) {
  return request({
    method: "put",
    url: combine(uuid),
    data: data,
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function AddUserSkill(data) {
  return request({
    method: "post",
    url: BASE_URL,
    data: data.skillName,
    headers: {
      "Content-Type": "application/json",
    },
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}

export function DeleteUserSkill(uuid) {
  return request({
    method: "delete",
    url: combine(uuid),
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}
