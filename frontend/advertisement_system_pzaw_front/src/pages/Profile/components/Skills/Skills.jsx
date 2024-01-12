import Card from "components/common/Card/Card";

export default function Skills(){
    return (
        <Card header = "Umiejętności" id="umiejetnosci">
            <ul class="list-group list-group-flush">
              {
                [ //tutaj będzie odpowiedź z rest api 
                  {
                    "skill_name" : "Skill 1"
                  },
                  {
                    "skill_name" : "Skill 2"
                  },
                  {
                    "skill_name" : "Skill 3"
                  },
                  {
                    "skill_name" : "max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill max length skill "
                  },
                  {
                    "skill_name" : "Skill 5"
                  },
                ].map((value) => {
                    return (
                      <li className='list-group-item'>
                          {value.skill_name}
                      </li>
                    )
                })
              }
            </ul>
        </Card>
    )
}