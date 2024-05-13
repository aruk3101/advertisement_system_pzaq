import { useState } from "react";

export default function useForm(initialState = {}, onSubmit) {
  const [data, setData] = useState(initialState);

  const handleChange = (e) => {
    console.log(data);
    console.log(e.target.value);
    console.log(e.target.name);
    setData((prevData) => ({ ...prevData, [e.target.name]: e.target.value }));
    console.log(data);
  };

  return { data, handleChange };
}
