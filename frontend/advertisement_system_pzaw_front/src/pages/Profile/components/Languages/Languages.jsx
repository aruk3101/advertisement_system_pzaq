import Card from "components/common/Card/Card";
import InputGroup from "components/common/InputGroup/InputGroup";

export default function Languages(){
    return (
        <Card header = "Języki" bootstrapFontsize = "fs-5" headerCenter = "text-center" id="jezyki">
            {[
              {
                "language" : "Angielski",
                "level" : "C2"
              },
              {
                "language" : "Niemiecki",
                "level" : "B1"
              },
              {
                "language" : "Francuski",
                "level" : "A1"
              },
            ].map((value, index) => { 
              return (
                <InputGroup
                  id={"language-addon-" + index}
                  firstElement = {
                    value.level
                  }
                  aria_label={"language-addon-" + index}
                  value = {value.language}
                />
              )
            })}
          </Card>
    )
}