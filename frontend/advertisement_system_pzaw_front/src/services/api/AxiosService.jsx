import axios from "axios";

function errorHandler(response) {
  if (!response) return;
  let httpResponse = {
    status: response.status,
  };
  try {
    if (response.status == 400) {
      httpResponse = {
        ...httpResponse,
        isSuccesfull: false,
        violations: response.data.violations,
      };
    } else if (
      response.status == 401 ||
      response.status == 412 ||
      response.status == 404
    ) {
      httpResponse = {
        ...httpResponse,
        isSuccesfull: false,
        message: response.data.message,
      };
    } else {
      httpResponse = {
        ...httpResponse,
        isSuccesfull: false,
        message: "An unexpected error occured",
      };
    }
    return httpResponse;
  } catch (error) {
    return {
      ...httpResponse,
      isSuccesfull: false,
      message: "An unexpected error occured",
    };
  }
}

export function BASE_URL_API() {
  return BASE_URL() + "/api/";
}

export function BASE_URL() {
  console.log(process.env);
  console.log(process.env.REACT_APP_NODE_ENV);
  if (process.env.REACT_APP_NODE_ENV.trim() == "deploy") {
    return "https://advertisement-system-pzaw.onrender.com";
  } else {
    return "http://localhost:8080";
  }
}

export function request({ method, url, headers, data }) {
  let base = BASE_URL_API();
  return axios({
    method: method,
    url: base + url,
    headers: { ...headers, Authorization: localStorage.getItem("token") }, // TEMPORARY FIX - DON'T KNOW WHY axios.defaults.headers.common are not applied to the request
    data: data,
  })
    .then((res) => {
      res = { status: res.status, isSuccesfull: true, data: res.data };
      return res;
    })
    .catch((error) => {
      let res = errorHandler(error.response);
      return res;
    });
}
