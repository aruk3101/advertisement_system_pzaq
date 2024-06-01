import { request } from "./AxiosService";

const BASE_URL = "educationLevels/";

function combine(url) {
  return BASE_URL + url;
}

export function GetEducationLevels() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
