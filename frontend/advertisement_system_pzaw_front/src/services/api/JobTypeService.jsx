import { request } from "./AxiosService";

const BASE_URL = "JobTypes/";

function combine(url) {
  return BASE_URL + url;
}

export function GetJobTypes() {
  return request({
    method: "get",
    url: BASE_URL,
  }).then((res) => {
    return res;
  });
}
