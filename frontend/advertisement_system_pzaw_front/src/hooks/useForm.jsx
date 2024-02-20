import { useState } from "react";

export default function useForm(initialState = {}, onSubmit) {
  const [data, setData] = useState(initialState);

  const handleChange = (e) => {
    setData((prevData) => ({ ...prevData, [e.target.name]: e.target.value }));
  };

  return { data, handleChange };
}
