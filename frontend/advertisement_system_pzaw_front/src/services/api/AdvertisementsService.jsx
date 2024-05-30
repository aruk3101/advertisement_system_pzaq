import { request } from "./AxiosService";

const BASE_URL = "advertisements/";

function combine(url) {
  return BASE_URL + url;
}

function handleErrors(response) {
  switch (response.status) {
    default:
      return {
        ...response,
        message:
          "Wystąpił nieokreślony błąd, skontaktuj się z administratorem, lub spróbuj ponownie",
      };
  }
}

export function GetAdvertisements(page, size) {
  console.log(page + ", " + size);
  return request({
    method: "get",
    url: BASE_URL + "?page=" + page + "&size=" + size,
  }).then((res) => {
    if (!res.isSuccesfull) {
      return handleErrors(res);
    }
    return res;
  });
}
