package com.letscode.modeloentrega.resource;

import com.letscode.modeloentrega.domain.Cliente;
import com.letscode.modeloentrega.service.iClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/clientes")
public class ClienteResource {

    @Autowired
    private iClienteService service;

    @RequestMapping(value="calcular_idade", method = RequestMethod.GET)
    public ResponseEntity<Integer> calcularIdade(@RequestParam Integer codigo) {
        return ResponseEntity.status(HttpStatus.OK).body(service.calcularIdadeCliente(codigo));
    }

    @RequestMapping(value="listar", method = RequestMethod.GET)
    public ResponseEntity<List<String>> listarNomesClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarNomesClientes());
    }

    @RequestMapping(value="consultar_nome", method = RequestMethod.GET)
    public ResponseEntity<String> consultarNomeCliente(@RequestParam Integer codigo) {
        return ResponseEntity.status(HttpStatus.OK).body(service.consultarNomeCliente(codigo));
    }

    @RequestMapping(value="listar_mulheres", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listarMulheresContato() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarClientesContato());
    }

    @RequestMapping(value="bug", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> metodoBugado() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listaQuebrada());
    }
}
