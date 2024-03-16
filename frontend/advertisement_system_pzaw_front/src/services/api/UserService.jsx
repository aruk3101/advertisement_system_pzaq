import { request } from "./AxiosService";

const BASE_URL = "users/";

function combine(url) {
  return BASE_URL + url;
}

export function Info() {
  return request({
    method: "get",
    url: combine("info"),
  }).then((res) => {
    if (!res.isSuccesfull) {
      return {
        ...res,
        message:
          "Wystąpił nieokreślony błąd, skontaktuj się z administratorem, lub spróbuj ponownie",
      };
    }
    return res;
  });
}
