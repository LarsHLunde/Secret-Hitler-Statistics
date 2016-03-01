--Amount of facist cards in pile
facist = 11
--Amount of liberal cards in pile
liberal = 6
result = {}

function node(chance, index, lib, fac)
    tnode = {chance = chance, lib = lib, fac = fac}
    result[index] = tnode
    
    if index < 8 then
        node(chance*(fac/(fac+lib)), index * 2, lib, fac -1)
        node(chance*(lib/(fac+lib)), (index * 2)+1, lib -1, fac)
    end
end

node(1,1,liberal,facist)
twofacist = result[9].chance + result[10].chance + result[12].chance
twoliberal = result[13].chance + result[14].chance

print("Chance for 3 facist\t\t" .. result[8].chance*100 .. " %")
print("Chance for 3 liberal\t\t" .. result[15].chance*100 .. " %")
print("Chance for 2 facist 1 liberal\t" .. twofacist*100 .. " %")
print("Chance for 2 liberal 1 facist\t" .. twoliberal*100 .. " %")

--[[
result is a binary tree as follows:
        f                   l
   ff        fl       lf        ll
fff  ffl  flf  fll lff  lfl  llf  lll
--]]
